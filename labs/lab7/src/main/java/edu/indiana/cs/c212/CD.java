package edu.indiana.cs.c212;

import java.util.ArrayList;

public class CD extends Media{

	private ArrayList<MP3> trackList;
	private String artist;
	private String publisher;
	private int numberOfTracks;
	private String genre;
	
	/**
	 * In addition to setting all the incoming parameters, the CD
	 * constructor also sets the lengthInSeconds of the CD.
	 * 
	 * @param title, the title of the CD
	 * @param artist, the recording artist for the CD
	 * @param copyrightYear, the year the CD was copyright
	 * @param tracks, an ArrayList<MP3> of tracks on the CD
	 * @param publisher, the publisher of the CD
	 * @param genre, the genre of the CD
	 */
	public CD(String title, String artist, int copyrightYear, ArrayList<MP3> tracks, String publisher, String genre){
		//FIXME
	}
	
	/* (non-Javadoc)
	 * @see edu.indiana.cs.c212.MediaItem#makeCopy()
	 */
	@Override
	public CD makeCopy() {
		//FIXME
		return null;
	}
	
	/**
	 * @return the publisher of this CD
	 */
	public String getPublisher(){
		//FIXME
		return null;
	}
	
	/**
	 * @return the genre of this CD
	 */
	public String getGenre(){
		//FIXME
		return null;
	}
	
	/**
	 * Sets the genre of this CD to the given genre
	 * 
	 * @param genre, the genre this CD will be
	 */
	public void setGenre(String genre){
		//FIXME
	}
	
	/**
	 * @return the number of tracks on this CD
	 */
	public Integer getNumberOfTracks(){
		//FIXME
		return null;
	}
	
	/**
	 * @return the recording artist for this CD
	 */
	public String getArtist(){
		//FIXME
		return null;
	}
	
	/**
	 * @return and ArrayList<MP3> of all the tracks on this CD
	 */
	public ArrayList<MP3> getTracks(){
		//FIXME
		return null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object objcd){
		if(objcd instanceof CD){
			CD cd = (CD) objcd;
			boolean base = this.title.equals(cd.title) &&
							this.artist.equals(cd.artist) &&
							this.copyrightYear == cd.copyrightYear &&
							this.numberOfTracks == cd.numberOfTracks &&
							this.publisher.equals(cd.publisher) &&
							this.genre.equals(cd.genre) &&
							this.trackList.equals(cd.trackList);
			if(base){
				for(int i = 0; i < cd.numberOfTracks; i++){
					if(!this.trackList.get(i).equals(cd.trackList.get(i))){
						return false;
					}
				}
				return true;
			}
		}	
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return (this.title + " - " + this.artist + " (" + this.copyrightYear +")");
	}
}
