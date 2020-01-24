/**Abstract class of animal
 * 
 * @author Bhavesh
 *
 */
abstract class Zoo {
	/**Method of add an animal to cage
	 * 
	 * @param a param a Animal object which will be added
	 * @return return true if successfull else false
	 */
	abstract boolean alocateAnimal(Animal a);
	/** method to remove any animal from code
	 * 
	 * @param a Animal object which will be removed
	 * @return true if successfull else false
	 */
	abstract boolean removeAnimal(Animal a);
	/**
	 * Method to create new cage
	 */
	abstract void createNewCage();

}