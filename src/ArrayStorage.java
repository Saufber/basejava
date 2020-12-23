/**
 * Array based storage for Resumes
 */


public class ArrayStorage {
    Resume[] storage = new Resume[10000];


    private int getIndexNOTnull(Resume[] storage){
        int index = 0;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }

    private int getIndex(Resume[] buffer, String uuid) {

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i].uuid.equals(uuid)) return i;
        }
        return -1;
    }



    void clear() {
        for (int i = 0; i < getIndexNOTnull(storage); i++){
            storage[i]=null;
        }

    }

    void save(Resume r) {
        storage[getIndexNOTnull(storage)]=r;
    }

    Resume get(String uuid) {

        for (int i = 0; i < getIndexNOTnull(storage); i++) {
            if (this.getAll()[i].uuid.equals(uuid)) return this.getAll()[i];
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] buffer1 = this.getAll();
        Resume[] buffer2 = new Resume[this.getAll().length-1];

        int index = getIndex(buffer1,uuid);

        // Copy the elements at the left of the index.
        System.arraycopy(buffer1, 0, buffer2, 0, index);
        // Copy the elements at the right of the index.
        System.arraycopy(buffer1, index + 1, buffer2, index, buffer1.length - index - 1);

        //System.out.println(Arrays.toString(buffer2));

        System.arraycopy(buffer2, 0, storage, 0, buffer2.length);
        storage[buffer1.length-1]=null;

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] storageNOTnull = new Resume[getIndexNOTnull(storage)];
        if (getIndexNOTnull(storage) >= 0) System.arraycopy(storage, 0, storageNOTnull, 0, getIndexNOTnull(storage));

        return storageNOTnull;
    }

    int size() {
        return getIndexNOTnull(storage);
    }
}
