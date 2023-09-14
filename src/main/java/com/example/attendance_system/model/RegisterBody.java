package com.example.attendance_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegisterBody (

        String email,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName
)
{}
