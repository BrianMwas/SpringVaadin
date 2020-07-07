package com.briandev.springvaadin

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringvaadinApplication

fun main(args: Array<String>) {
	runApplication<SpringvaadinApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}
