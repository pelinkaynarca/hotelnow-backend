package com.tobeto.java4a.hotelnow.core.configurations.fakeusers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;

@ConfigurationProperties(prefix = "env.development.fakeuser")
@Configuration("fakeUser")
public class FakeUser extends User{
}
