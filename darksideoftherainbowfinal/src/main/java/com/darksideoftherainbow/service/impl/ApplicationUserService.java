package com.darksideoftherainbow.service.impl;

import com.darksideoftherainbow.model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findByUserName(String username);
}
