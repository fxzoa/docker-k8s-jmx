package com.fxzoa.demo;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		writeEnvs();
        System.out.println("# ------------------------ [ Args ] --------------------------- #");
        Arrays.stream(args).forEach(arg -> System.out.println("# arg: " + arg));
        System.out.println("\r\n");
		SpringApplication.run(DemoApplication.class, args);
	}

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String hello(HttpServletRequest req) {
    	System.out.println("## DemoApplication#hello(..) [BEGIN] ##");
    	StringBuilder sb = new StringBuilder();
    	sb.append("  getRequestURL: ");
    	sb.append(req.getRequestURL());
    	sb.append("; getRequestURI: ");
    	sb.append(req.getRequestURI());
    	sb.append("; getServletPath: ");
    	sb.append(req.getServletPath());
        
		System.out.println("## HTTP Response: ["+ sb.toString() + " ] ##");
    	System.out.println("## DemoApplication#hello(..) [END] ##");
        return "{\"status\": 200, \"result\": \"" + sb.toString() + "\", \"errors\": null}";
    }

    private static void writeEnvs() {
        System.out.println("# ------------------------ [ Envs ] --------------------------- #");
        System.getenv().forEach((k, v) -> System.out.println("# " + k + " : " + v));
        System.out.println("\r\n");
    }
}
