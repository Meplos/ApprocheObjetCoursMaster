package fr.ubordeaux.ao;

import java.util.Set;

public interface Catalog {
    int size();
    Set<Reference> getReferences();
    Reference findReferenceById(String id);
    void addReference(Reference reference);
    void removeReference(Reference reference);
}
