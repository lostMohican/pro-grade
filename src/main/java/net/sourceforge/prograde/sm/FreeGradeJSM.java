package net.sourceforge.prograde.sm;

import net.sourceforge.prograde.policy.ProGradePolicy;

import java.security.Policy;

/**
 * Class extending Security Manager and uses \"free.security.policy\"
 * as a system property
 * the main reason for this development is for running tests in
 * contained environments like gradle and junit
 * when supplied a policy file with deny entries in it, Gradle's own
 * security manager tries to parse it and that causes problems
 * this way, gradle cannot parse your deny policy file
 *
 * @author Erkin Unlu
 */
public class FreeGradeJSM extends SecurityManager {

    /**
     * Constructor which uses free.security.policy system property
     */
    public FreeGradeJSM() {
        super();
        Policy.setPolicy(new ProGradePolicy("free.security.policy"));
    }
}
