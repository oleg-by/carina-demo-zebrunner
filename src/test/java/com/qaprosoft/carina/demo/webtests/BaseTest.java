package com.qaprosoft.carina.demo.webtests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.webautomationpractice.services.AuthenticationService;

public class BaseTest extends AbstractTest {
    protected AuthenticationService authenticationService = new AuthenticationService();

}
