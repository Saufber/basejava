public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.uuid);
        if (index == -1) {
            System.out.println("Resume " + r.uuid + " not exist");
        } else {
            storage[index] = r;
        }
    }
    
    public void save(Resume r) {
        if (getIndex(r.uuid) != -1) {
            System.out.println("Resume " + r.uuid + " already exist");
        } else if(size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }

    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume  " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume  " + uuid + " not exist");
        } else {
            System.arraycopy(storage, index+1, storage, index, size-index);
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size];
        if (size >= 0) System.arraycopy(storage, 0, result, 0, size);
        return result;
    }

    int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) return i;
        }
        return -1;
    }
}
