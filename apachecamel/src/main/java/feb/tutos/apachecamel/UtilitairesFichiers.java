package feb.tutos.apachecamel;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.SecurityException;
import java.lang.UnsupportedOperationException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UtilitairesFichiers {

    public static Path creerFichier(String cheminDossier, String nomFichier) {
        if (cheminDossier == null || cheminDossier.trim().isEmpty()) {
            System.out.println("Dossier parent null ou vide");
            return null;
        }
        Path path = Paths.get(cheminDossier, nomFichier);
        if (!Files.exists(path.getParent())) {
            System.out.println("Dossier parent n'existe pas : " + cheminDossier);
            return null;
        }
        return creerFichier(path);
    }

    public static Path creerFichier(URI fichierURI) {
        try {
            Path path = Paths.get(fichierURI);
            return creerFichier(path);
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgument exception : " + e.getMessage());
        }
        catch (FileSystemNotFoundException e) {
            System.out.println("FileSystemNotFound exception : " + e.getMessage());
        }
        catch (SecurityException e) {
            System.out.println("Security exception : " + e.getMessage());
        }
        return null;
    }

    public static Path creerFichier(Path fichierPath) {
        try {
            return Files.createFile(fichierPath);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException : " + e.getMessage());
        }
        catch (FileAlreadyExistsException e) {
            System.out.println("FileAlreadyExistsException: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
        return null;
    }

    public static boolean supprimerFichier( String noeud1, String... suiteNoeuds ) throws InvalidPathException {
        try {
            Path path = Paths.get( noeud1, suiteNoeuds );
            return supprimerFichier( path );
        }
        catch ( InvalidPathException e ) {
            System.out.println("InvalidPathException : " + e.getMessage());
        }
        catch ( IOException e ) {
            System.out.println("IOException : " + e.getMessage());
        }
        return false;
    }

    public static boolean supprimerFichier( Path fichierPath ) throws IOException {
        if ( fichierPath != null ) {
            try {
                return Files.deleteIfExists( fichierPath );
            }
            catch ( IOException e ) {
                System.out.println("IOException : " + e.getMessage());
            }
        }
        return false;
    }

    public static void ecrireLigne( Path fichierPath, List<String> lignes ) {
        try ( BufferedWriter ecrivain = new BufferedWriter( new FileWriter( fichierPath.toFile() ))) {
            for ( String l : lignes ) {
                ecrivain.write( l );
                ecrivain.newLine();
            }
        }
        catch ( IOException e ) {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
