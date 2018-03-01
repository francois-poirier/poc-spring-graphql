package poc.fpo.services.pocspringgraphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Album {
	
    @Id
    @Column(name="album_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="album_title", nullable = false)
    private String title;

    @Column(name="album_duration", nullable = false)
    private Integer duration;
    
    @Column(name="album_genre", nullable = false)
    private String genre;


    @Column(name="album_pageCount", nullable = false)
    private int pageCount;

    @ManyToOne
    @JoinColumn(name = "artist_id",
            nullable = false, updatable = false)
    private Artist artist;

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(String title, Integer duration, String genre, int pageCount, Artist artist) {
		super();
		this.title = title;
		this.duration = duration;
		this.genre = genre;
		this.pageCount = pageCount;
		this.artist = artist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + pageCount;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getDuration() {
		return duration;
	}

	public String getGenre() {
		return genre;
	}

	public int getPageCount() {
		return pageCount;
	}

	public Artist getArtist() {
		return artist;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pageCount != other.pageCount)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
		
	}
    
    
}
