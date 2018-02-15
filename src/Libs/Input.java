package Libs;

/**
 *  <i>Binary standard input</i>. This class provides methods for reading
 *  in bits from standard input, either one bit at a time (as a {@code boolean}),
 *  8 bits at a time (as a {@code byte} or {@code char}),
 *  16 bits at a time (as a {@code short}), 32 bits at a time
 *  (as an {@code int} or {@code float}), or 64 bits at a time (as a
 *  {@code double} or {@code long}).
 *  <p>
 *  All primitive types are assumed to be represented using their
 *  standard Java representations, in big-endian (most significant
 *  byte first) order.
 *  <p>
 *  The client should not intermix calls to {@code BinaryStdIn} with calls
 *  to {@code StdIn} or {@code System.in};
 *  otherwise unexpected behavior will result.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

/**
 * IT'S NOT FULL IMPLEMENTATION
 */

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

public final class Input {
    private static          BufferedInputStream in;
    private static int      buffer;
    private static int      buffer_bits_left;
    private static boolean  isInitialized;


    private static void initialize() {
        in = new BufferedInputStream(System.in);
        buffer              = 0;
        buffer_bits_left    = 0;
        fillBuffer();
        isInitialized       = true;
        }

    private static void fillBuffer() {
        try {
            buffer              = in.read();
            buffer_bits_left    = 8;
        } catch (IOException none) {
            System.out.println("EOF");
            buffer              = -1;
            buffer_bits_left    = -1;
        }
    }

    public static void close() {
        if(!isInitialized)
            initialize();
            try {
                in.close();
                isInitialized = false;
            } catch (IOException none) {
                System.out.println("Could not close Input.close()");
            }

    }

    public static boolean isEmpty() {
        if(!isInitialized)
            initialize();
        return buffer == -1;

    }

    public static boolean readBoolean() {
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");
        buffer_bits_left--;
        boolean bit = ((buffer >> buffer_bits_left) & 1) == 1;
        if (buffer_bits_left == 0) fillBuffer();
        return bit;
    }


    /**
     * Reads the next 8 bits from standard input and return as an 8-bit char.
     * Note that {@code char} is a 16-bit type;
     * to read the next 16 bits as a char, use {@code readChar(16)}.
     *
     * @return the next 8 bits of data from standard input as a {@code char}
     * @throws NoSuchElementException if there are fewer than 8 bits available on standard input
     */
    public static char readChar() {
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");

        // special case when aligned byte
        if (buffer_bits_left == 8) {
            int x = buffer;
            fillBuffer();
            return (char) (x & 0xff);
        }

        // combine last n bits of current buffer with first 8-n bits of new buffer
        int x = buffer;
        x <<= (8 - buffer_bits_left);
        int oldN = buffer_bits_left;
        fillBuffer();
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");
        buffer_bits_left = oldN;
        x |= (buffer >>> buffer_bits_left);
        return (char) (x & 0xff);
        // the above code doesn't quite work for the last character if n = 8
        // because buffer will be -1, so there is a special case for aligned byte
    }

    /**
     * Reads the next r bits from standard input and return as an r-bit character.
     *
     * @param  r number of bits to read.
     * @return the next r bits of data from standard input as a {@code char}
     * @throws NoSuchElementException if there are fewer than {@code r} bits available on standard input
     * @throws IllegalArgumentException unless {@code 1 <= r <= 16}
     */
    public static char readChar(int r) {
        if (r < 1 || r > 16) throw new IllegalArgumentException("Illegal value of r = " + r);

        // optimize r = 8 case
        if (r == 8) return readChar();

        char x = 0;
        for (int i = 0; i < r; i++) {
            x <<= 1;
            boolean bit = readBoolean();
            if (bit) x |= 1;
        }
        return x;
    }



    /**
     * Reads the remaining bytes of data from standard input and return as a string.
     *
     * @return the remaining bytes of data from standard input as a {@code String}
     * @throws NoSuchElementException if standard input is empty or if the number of bits
     *         available on standard input is not a multiple of 8 (byte-aligned)
     */
    public static String readString() {
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");

        StringBuilder sb = new StringBuilder();
        while (!isEmpty()) {
            char c = readChar();
            sb.append(c);
        }
        return sb.toString();
    }
}
