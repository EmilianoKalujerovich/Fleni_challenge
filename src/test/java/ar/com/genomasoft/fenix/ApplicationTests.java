package ar.com.genomasoft.fenix;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ar.com.genomasoft.fenix.config.Application;
import ar.com.genomasoft.jproject.core.exception.BaseException;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes = {Application.class})
public class ApplicationTests {

	

}
