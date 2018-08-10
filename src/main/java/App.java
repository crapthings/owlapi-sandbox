import java.io.File;
import java.util.stream.Collectors;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.formats.TurtleDocumentFormat;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws OWLOntologyCreationException, OWLOntologyStorageException {
        System.out.println(new App().getGreeting());
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File("resources/kg.owl"));
        //ontology.saveOntology(new TurtleDocumentFormat(), System.out);
        for (OWLClass oc : ontology.classesInSignature().collect(Collectors.toSet())) {
            System.out.println("Class: " + oc.toString());
        }

        for (OWLIndividual ind : ontology.individualsInSignature().collect(Collectors.toSet())) {
            System.out.println("Ind: " + ind.toString());
        }
    }
}
