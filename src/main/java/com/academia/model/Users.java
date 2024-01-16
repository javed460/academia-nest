package com.academia.model;

import org.springframework.data.annotation.Id;

public record Users(@Id Integer id, String username, String password) {
}