package persisterinterface;

/**
 * This interface is an abstraction for the algorithm persist.
 */
public interface ProfilePersister
{
	/**
	 * Persists a user profile in binary or json format.
	 * @param pInt An object that represents the interest of a user to save.
	 * @param pFilename is the filename and the whole path to where the object is persisted into 
	 */
	void persist(Integer pInt, String pFilename);
}
