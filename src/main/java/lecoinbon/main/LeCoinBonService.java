package lecoinbon.main;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	public List<Annonce> findAllPagination(int page){
		int nbMaxPerPage = 2 * page;	
		return annonceRepo.findAllAnnoncesWithPagination(2,nbMaxPerPage);
	}
	
	public List<Annonce> findAllByKeywordInDescription(String keyword, int page){
		int nbMaxPerPage = 2 * page;
		return annonceRepo.findAllAnnoncesWithPaginationByKeywordInDescription(keyword, 2,nbMaxPerPage);
	}
	
	public List<Annonce> findAllByKeywordInDescription(String keyword){
		return annonceRepo.findAllAnnoncesWithPaginationByKeywordInDescription(keyword);
	}
	
	public List<Annonce> findAllByKeywordInTitle(String keyword, int page){
		int nbMaxPerPage = 2 * page;
		return annonceRepo.findAllAnnoncesWithPaginationByKeywordInTitle(keyword, 2,nbMaxPerPage);
	}
	
	public List<Annonce> findAllByKeywordInTitle(String keyword){
		return annonceRepo.findAllAnnoncesWithPaginationByKeywordInTitle(keyword);
	}
}
