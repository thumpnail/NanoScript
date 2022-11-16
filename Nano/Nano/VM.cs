using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Nano.Nano {
    public class VM  {
        private byte[] chunk;
        private Stack<byte> stack = new();

        public VM(byte[] chunk) {
            this.chunk = chunk;
        }

        public void Execute() {
            byte c;
            int i = 0;
            while ((c = chunk[i++]) != (byte)0b11111111 || (c = chunk[i+1]) != (byte)0b00000000) {
                Console.WriteLine($"ExecByte:{c}");
            }
        }
    }
}
