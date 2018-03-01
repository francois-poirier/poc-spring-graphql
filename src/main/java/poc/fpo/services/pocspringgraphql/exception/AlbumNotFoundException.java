package poc.fpo.services.pocspringgraphql.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class AlbumNotFoundException extends RuntimeException implements GraphQLError{

	   private Map<String, Object> extensions = new HashMap<>();

	    public AlbumNotFoundException(String message, Long invalidAlbumId) {
	        super(message);
	        extensions.put("invalidAlbumId", invalidAlbumId);
	    }

	    @Override
	    public List<SourceLocation> getLocations() {
	        return null;
	    }

	    @Override
	    public Map<String, Object> getExtensions() {
	        return extensions;
	    }

	    @Override
	    public ErrorType getErrorType() {
	        return ErrorType.DataFetchingException;
	    }

}
