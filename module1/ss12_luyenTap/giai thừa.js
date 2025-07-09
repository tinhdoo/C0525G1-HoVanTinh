function factorial(n) {
  if (n === 1) return 1;          // ✋ Khi còn 1 thì dừng lại
  return n * factorial(n - 1);   // 🔁 Gọi lại chính nó với số nhỏ hơn
}

