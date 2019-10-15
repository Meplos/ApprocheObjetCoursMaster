package fr.ubordeaux.ao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CatalogImpl implements Catalog {
    private Map<String, Reference> references;

    public CatalogImpl() {
       this.references = new HashMap<String, Reference>();
    }

    public int size() {
        return this.references.size();
    }

    public Set<Reference> getReferences() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(this.references.values());
        return result;
    }

    public Reference findReferenceById(String id) {
        if (!references.containsKey(id)) {
            throw new
                ReferenceManagementException(
                    "cannot find Reference, id unknown !"
                );
        }
        return this.references.get(id);
    }

    public void addReference(Reference reference) {
        if (reference == null) {
            throw new RuntimeException();
        }
        this.references.put(reference.getId(), reference);
    }

    public void removeReference(Reference reference) {
        this.references.remove(reference.getId());
    }
}
