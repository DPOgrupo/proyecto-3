package Venta_de_tiquetes;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class GeneradorDeQR {

    public static void generarQR(String datos, String nombreArchivo) throws WriterException, IOException {
        QRCodeWriter qrWriter = new QRCodeWriter();
        BitMatrix matrix = qrWriter.encode(datos, BarcodeFormat.QR_CODE, 300, 300);

        Path rutaArchivo = new File("QR/" + nombreArchivo + ".png").toPath();
        MatrixToImageWriter.writeToPath(matrix, "PNG", rutaArchivo);
        
        System.out.println("se generó");
    }
}
