package edu.upc.gessi.rptool.rest.dtos;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import edu.upc.gessi.rptool.domain.Source;
import edu.upc.gessi.rptool.domain.schema.ClassificationObject;

@JsonInclude(Include.NON_NULL)
public abstract class ClassificationObjectDTO {
    private long id;
    private String description;
    private String comments;
    private Set<SourceDTO> sources;

    public ClassificationObjectDTO(ClassificationObject s) {
	this.id = s.getId();
	this.description = s.getDescription();
	this.comments = s.getComments();
	this.sources = new HashSet<>();

	Set<Source> sourcesAux = s.getSources();
	for (Source source : sourcesAux) {
	    this.sources.add(new SourceDTO(source, true));
	}
    }

    public ClassificationObjectDTO(long id, String description, String comments, Set<SourceDTO> sources) {
	super();
	this.id = id;
	this.description = description;
	this.comments = comments;
	this.sources = sources;
    }

    public long getId() {
	return id;
    }

    public String getComments() {
        return comments;
    }

    public String getDescription() {
	return description;
    }

    public Set<SourceDTO> getSources() {
	return sources;
    }
}
