package org.imaginea.demo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Charanjit Singh
 */

public class NoCityFoundException extends Throwable {
    private static final Logger LOG = LoggerFactory.getLogger(NoCityFoundException.class);

    public NoCityFoundException(String s) {
        super(s);
    }
}
