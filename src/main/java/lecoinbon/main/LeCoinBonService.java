package lecoinbon.main;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeCoinBonService {
	@Autowired
	AnnonceRepository annonceRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Annonce> findAll(){
		return annonceRepo.findAll();
	}
	
	public void save(Annonce annonce) {
		annonceRepo.save(annonce);
	}
}
