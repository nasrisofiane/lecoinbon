package lecoinbon.main;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LeCoinBonController {
	@Autowired
	LeCoinBonService leCoinBonService;
	
	@RequestMapping("/") //lance Home au lancement de la page web.
	public String home(Model m/* Donne des infos au JSP */){
		List<Annonce> annonce = leCoinBonService.findAll();
		m.addAttribute("annonces", annonce); 
		return "index";
	}
	
	@RequestMapping(value = "/addAnnonce", method = RequestMethod.GET)
	    public ModelAndView showForm() {
	    return new ModelAndView("annonceAddView", "annonce", new Annonce());
	}
	
	@RequestMapping(value = "/addAnnonce", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("annonce")Annonce annonce, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "annonceAddView";
        }
        model.addAttribute("titre", annonce.getTitre());
        model.addAttribute("description", annonce.getDescription());
        leCoinBonService.save(annonce);
        return "successfullAddedAnnonce";
    }
	
	@RequestMapping(value = "/getAnnonces", method = RequestMethod.GET)
    public ModelAndView getAnnonces(@RequestParam int page) {
		int nbPages = (int)Math.ceil(leCoinBonService.findAll().size()/2 );
		ModelAndView mav = new ModelAndView("annonces");
		if(leCoinBonService.findAllPagination(nbPages).size() < 1) {
			nbPages -= 1;
		}
		mav.addObject("annonces", leCoinBonService.findAllPagination(page));
		mav.addObject("nbpages", nbPages);
		return mav;
	}
	
	@RequestMapping(value = "/searchbox", method = RequestMethod.GET)
    public ModelAndView getAnnonces(@RequestParam(required = false) String keyword, @RequestParam(required = false) String page, @RequestParam(required = false) String searchby) {
		ModelAndView mav = new ModelAndView("searchbox");
		String keywordStrong = "<strong class='keyword'>"+keyword+"</strong>";
		System.out.println(searchby);
		if(keyword != null && keyword != "" && searchby != null) {
			if(page == null && page != "") {
				page = "0";
			}
			int nbPages = 0;
			if(searchby.equals("description")) {
				nbPages = (int)Math.ceil(leCoinBonService.findAllByKeywordInDescription(keyword).size()/2 );
				mav.addObject("annonces", leCoinBonService.findAllByKeywordInDescription(keyword, Integer.parseInt(page)));
			}
			else if(searchby.equals("titre")) {
				nbPages = (int)Math.ceil(leCoinBonService.findAllByKeywordInTitle(keyword).size()/2 );
				mav.addObject("annonces", leCoinBonService.findAllByKeywordInTitle(keyword, Integer.parseInt(page)));
			}
			if(leCoinBonService.findAllByKeywordInTitle(keyword, nbPages).size() < 1) {
				nbPages -= 1;
			}
			mav.addObject("keyword", keyword.toLowerCase());
			mav.addObject("nbpages", nbPages);
			mav.addObject("searchby", searchby);
			mav.addObject("keywordStrong", keywordStrong.toLowerCase());
		}
		return mav;
	}
	
	
	
}
