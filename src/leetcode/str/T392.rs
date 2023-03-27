pub struct Solution {

}

impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool{
        let mut i: usize = 0;
        let s_bytes = s.as_bytes();
        let t_bytes = t.as_bytes();
        for j in 0..t.len() {
            if i < s.len() {
                if s_bytes.get(i) == t_bytes.get(j){
                    i += 1;
                }
            }
        }
        i == s.len()
    }
}