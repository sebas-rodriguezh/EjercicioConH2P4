package com.example.proyectoregistroh2.data;

import com.example.proyectoregistroh2.logic.Documento;
import com.example.proyectoregistroh2.logic.Tipo;
import com.example.proyectoregistroh2.logic.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{

    private final UsuarioRepository usuarioRepository;
    private final TipoRepository tipoRepository;
    private final DocumentoRepository documentoRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsuarioRepository usuarioRepository,
                      TipoRepository tipoRepository,
                      DocumentoRepository documentoRepository,
                      PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tipoRepository = tipoRepository;
        this.documentoRepository = documentoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception
    {
        if (tipoRepository.count() == 0) {
            Tipo tipo1 = new Tipo();
            tipo1.setId("1");
            tipo1.setNombre("Personas Juridicas");
            tipoRepository.save(tipo1);

            Tipo tipo2 = new Tipo();
            tipo2.setId("2");
            tipo2.setNombre("Bienes Inmuebles");
            tipoRepository.save(tipo2);

            Tipo tipo3 = new Tipo();
            tipo3.setId("3");
            tipo3.setNombre("Bienes Muebles");
            tipoRepository.save(tipo3);

            Tipo tipo4 = new Tipo();
            tipo4.setId("4");
            tipo4.setNombre("Catastro");
            tipoRepository.save(tipo4);

            System.out.println("Tipos insertados correctamente.");
        }

        if (usuarioRepository.count() == 0) {
            Usuario usuario1 = new Usuario();
            usuario1.setId("JPerez");
            usuario1.setClave(passwordEncoder.encode("111"));
            usuario1.setRol("CLI");
            usuarioRepository.save(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setId("MMata");
            usuario2.setClave(passwordEncoder.encode("222"));
            usuario2.setRol("CLI");
            usuarioRepository.save(usuario2);

            System.out.println("Usuarios insertados correctamente.");
        }

        if (documentoRepository.count() == 0) {
            Tipo tipo1 = tipoRepository.findById("1").orElse(null);
            Tipo tipo2 = tipoRepository.findById("2").orElse(null);
            Tipo tipo3 = tipoRepository.findById("3").orElse(null);
            Tipo tipo4 = tipoRepository.findById("4").orElse(null);

            crearDocumento("DOC01", "Certificado de Constitución", 1333f, 510f, tipo1);
            crearDocumento("DOC02", "Certificado de Representación Legal", 10000f, 500f, tipo1);
            crearDocumento("DOC03", "Certificado de Vigencia", 8000f, 300f, tipo1);
            crearDocumento("DOC04", "Certificado de Accionistas", 12000f, 400f, tipo1);
            crearDocumento("DOC05", "Certificado de Domicilio Legal", 5000f, 200f, tipo1);

            crearDocumento("DOC06", "Certificado de Propiedad", 25000f, 1000f, tipo2);
            crearDocumento("DOC07", "Certificado de Gravámenes", 18000f, 800f, tipo2);
            crearDocumento("DOC08", "Certificado de Avalúo", 20000f, 800f, tipo2);
            crearDocumento("DOC09", "Certificado de Zonificación", 12000f, 500f, tipo2);
            crearDocumento("DOC10", "Certificado de Uso de Suelo", 15000f, 600f, tipo2);

            crearDocumento("DOC11", "Certificado de Matrícula", 8000f, 300f, tipo3);
            crearDocumento("DOC12", "Certificado de Gravamen", 6000f, 200f, tipo3);
            crearDocumento("DOC13", "Certificado de Propiedad Vehicular", 10000f, 400f, tipo3);
            crearDocumento("DOC14", "Certificado de Historial", 7000f, 250f, tipo3);

            crearDocumento("DOC15", "Certificado de Plano", 12000f, 500f, tipo4);
            crearDocumento("DOC16", "Certificado de Medidas", 9000f, 350f, tipo4);
            crearDocumento("DOC17", "Certificado de Linderos", 11000f, 450f, tipo4);
            crearDocumento("DOC18", "Certificado de Área", 8000f, 300f, tipo4);
            crearDocumento("DOC19", "Certificado de Nomenclatura", 5000f, 200f, tipo4);

            System.out.println("Documentos insertados correctamente.");
        }
    }

    private void crearDocumento(String id, String descripcion, float monto, float timbres, Tipo tipo) {
        Documento doc = new Documento();
        doc.setId(id);
        doc.setDescripcion(descripcion);
        doc.setMonto(monto);
        doc.setTimbres(timbres);
        doc.setTipo(tipo);
        documentoRepository.save(doc);
    }
}