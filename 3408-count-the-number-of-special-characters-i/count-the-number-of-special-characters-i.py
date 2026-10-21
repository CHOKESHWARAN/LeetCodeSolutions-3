class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        lower = set()
        upper = set()
        for char in word:
            if 'a' <= char <= 'z':
                lower.add(char)
            elif 'A' <= char <= 'Z':
                upper.add(char)
        
        count = 0
        for ch in lower:
            if ch.upper() in upper:
                count += 1
        return count