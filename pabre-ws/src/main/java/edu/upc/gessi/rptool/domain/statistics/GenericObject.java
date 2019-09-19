package edu.upc.gessi.rptool.domain.statistics;

import java.util.HashSet;
import java.util.Set;

import edu.upc.gessi.rptool.domain.Source;
import edu.upc.gessi.rptool.exceptions.IntegrityException;

public abstract class GenericObject {

    /*
     * ATTRIBUTES
     */

    private long id;
    private String name;
    private String description;
    private String comments;
    private Set<Source> sources;

    /*
     * CREATORS
     */

    public GenericObject() {
	name = null;
	description = null;
	comments = null;
	sources = new HashSet<>();
    }

    /*
     * GET'S AND SET'S METHODS
     */

    public long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getDescription() {
	return description;
    }

    public String getComments() {
	return comments;
    }

    public Set<Source> getSources() {
	return sources;
    }

    /*
     * OTHER METHODS
     */

    /**
     * The method used to convert one GenericObject to string
     * 
     * @return The name of the Generic Object
     */
    @Override
    public String toString() {
	return name;
    }

}