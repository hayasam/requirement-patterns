package edu.upc.gessi.rptool.rest.dtos.importexport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import edu.upc.gessi.rptool.domain.Source;

@JsonInclude(Include.NON_NULL)
public class SourceExportDTO {

    private long id;
    private String identifier;
    private String reference;
    private String type;
    private String comments;

    public SourceExportDTO(Source s) {
	super();
	this.id = s.getId();
	this.identifier = s.getIdentifier();
	this.reference = (s.getReference() != null) ? s.getReference() : "";
	this.type = (s.getType() != null) ? s.getType() : "";
	this.comments = (s.getComments() != null) ? s.getComments() : "";
    }

    public long getId() {
	return id;
    }

    public String getIdentifier() {
	return identifier;
    }

    public String getType() {
	return type;
    }

    public String getReference() {
        return reference;
    }

    public String getComments() {
	return comments;
    }

}
