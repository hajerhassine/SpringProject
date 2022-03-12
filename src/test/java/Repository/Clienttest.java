//package Repository;
//
//import java.util.Optional;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import tn.esprit.entities.Client;
//import tn.esprit.service.ClientServiceImpl;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class Clienttest {
//	@Autowired
//	ClientServiceImpl fs;
//	private static final Logger l = LogManager.getLogger(Clienttest.class);
//	@Test
//	public void testRetrieveFacture() {
//	Client client = fs.retrieveClient(1L);
//	l.info("retrieve : "+ client.getIdclient());
//}
//}
