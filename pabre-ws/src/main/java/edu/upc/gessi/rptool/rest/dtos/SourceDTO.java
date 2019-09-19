package edu.upc.gessi.rptool.rest.dtos;

import java.net.URI;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import edu.upc.gessi.rptool.domain.Source;

@JsonInclude(Include.NON_NULL)
public class SourceDTO {

    @InjectLink(value = "sources/${instance.id}", style = Style.ABSOLUTE)
    private URI uri;
    private long id;
    private String identifier;
    private String reference;
    private String type;
    private String comments;

    public SourceDTO(Source s) {
	this(s, false);
    }

    public SourceDTO(Source s, boolean onlyIdAndIdentifier) {
	super();
	this.id = s.getId();
	this.identifier = s.getIdentifier();
	if (!onlyIdAndIdentifier) {
	    this.reference = (s.getReference() != null) ? s.getReference() : "";
	    this.type = (s.getType() != null) ? s.getType() : "";
	    this.comments = (s.getComments() != null) ? s.getComments() : "";
	}
    }

    public URI getUri() {
        return uri;
    }

    public long getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getReference() {
        return reference;
    }
    public String getType() {
        return type;
    }

    public String getComments() {
        return comments;
    }

}
