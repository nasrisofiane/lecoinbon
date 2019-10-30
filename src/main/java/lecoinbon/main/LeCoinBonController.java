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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
