package model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import persisterinterface.ProfilePersister;

public class Model implements ProfilePersister
{
	private static Logger logger = Logger.getLogger(Model.class.getName());
	/**
	 * Constructor representing a Model object used to persist a profile in JSON format.
	 */
	public Model() 
	{
		logger.info("Persist file in model format");
	}
    /* 
     * Converts the object to JSON format.
     * writes to output folder.
     */
    @Override
    public void persist(Integer pInt, String pFilename)
    {
        String aJson = pInt.toString();

        try 
        {
			String out =  pFilename+".json";
            FileWriter writer = new FileWriter(out);
            writer.write(aJson);
            writer.close();
        }
        catch (IOException e)
        {
			logger.warning("JSON file could not created: " + pFilename+".json");
			return;
        } 
    }
}



