package com.uca.cinema.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie  {

	@Id
	@SequenceGenerator(name="MOVIE_IDMOVIE_GENERATOR", sequenceName="MOVIE_ID_MOVIE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIE_IDMOVIE_GENERATOR")
	@Column(name="id_movie")
	private Integer idMovie;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	private String director;

	private String genres;

	@Column(name="poster_link")
	private String posterLink;

	private String rating;

	private Integer runtime;

	private Boolean status;

	private String synopsis;

	private String title;

	@Column(name="trailer_link")
	private String trailerLink;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Showtime
	@OneToMany(mappedBy="movie")
	private List<Showtime> showtimes;

	public Movie() {
	}

	public Integer getIdMovie() {
		return this.idMovie;
	}

	public void setIdMovie(Integer idMovie) {
		this.idMovie = idMovie;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenres() {
		return this.genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getPosterLink() {
		return this.posterLink;
	}

	public void setPosterLink(String posterLink) {
		this.posterLink = posterLink;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getRuntime() {
		return this.runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrailerLink() {
		return this.trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Showtime> getShowtimes() {
		return this.showtimes;
	}

	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}

	public Showtime addShowtime(Showtime showtime) {
		getShowtimes().add(showtime);
		showtime.setMovie(this);

		return showtime;
	}

	public Showtime removeShowtime(Showtime showtime) {
		getShowtimes().remove(showtime);
		showtime.setMovie(null);

		return showtime;
	}

}