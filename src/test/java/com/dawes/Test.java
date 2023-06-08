package com.dawes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.servicio.ServicioVariedadImpl;

@SpringBootTest
class Test {

	@Autowired
	ServicioVariedadImpl sa;

}
