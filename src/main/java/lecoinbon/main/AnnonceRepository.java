package lecoinbon.main;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
	@Query( value = "SELECT * FROM annonces WHERE activated = true LIMIT :limitnb OFFSET :offsetnb", nativeQuery = true)
		List<Annonce> findAllAnnoncesWithPagination(@Param("limitnb") int limit,@Param("offsetnb") int offset);
	
	@Query( value = "SELECT * FROM annonces WHERE LOWER(description) LIKE CONCAT('%',LOWER(:keyword),'%') LIMIT :limitnb OFFSET :offsetnb", nativeQuery = true)
			List<Annonce> findAllAnnoncesWithPaginationByKeywordInDescription(@Param("keyword") String keyword, @Param("limitnb") int limitNb, @Param("offsetnb") int offsetNb);
		
	@Query( value = "SELECT * FROM annonces WHERE LOWER(description) LIKE CONCAT('%',LOWER(:keyword),'%')", nativeQuery = true)
		List<Annonce> findAllAnnoncesWithPaginationByKeywordInDescription(@Param("keyword") String keyword);
	
	@Query( value = "SELECT * FROM annonces WHERE LOWER(titre) LIKE CONCAT('%',LOWER(:keyword),'%') LIMIT :limitnb OFFSET :offsetnb", nativeQuery = true)
	List<Annonce> findAllAnnoncesWithPaginationByKeywordInTitle(@Param("keyword") String keyword, @Param("limitnb") int limitNb, @Param("offsetnb") int offsetNb);
	
	@Query( value = "SELECT * FROM annonces WHERE LOWER(titre) LIKE CONCAT('%',LOWER(:keyword),'%')", nativeQuery = true)
	List<Annonce> findAllAnnoncesWithPaginationByKeywordInTitle(@Param("keyword") String keyword);

	@Query( value = "SELECT * FROM annonces WHERE activated = false LIMIT :limitnb OFFSET :offsetnb", nativeQuery = true)
	List<Annonce> findAllByActivated(@Param("limitnb") int limitNb, @Param("offsetnb") int offsetNb);
	
	@Query( value = "SELECT * FROM annonces WHERE activated = false", nativeQuery = true)
	List<Annonce> findAllByActivated();
	
}
