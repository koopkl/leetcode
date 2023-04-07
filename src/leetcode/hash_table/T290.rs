use std::collections::HashMap;

pub struct Solution {

}
impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        let mut map = HashMap::new();
        let mut map_rev = HashMap::new();
        let words = s.split_whitespace().map(|x| x.to_string()).collect::<Vec<String>>();
        let chars = pattern.chars().collect::<Vec<char>>();
        if words.len() != chars.len() {
            return false
        }
        for i in 0..pattern.len() {
            let val = map.entry(chars[i]).or_insert(words[i].clone());
            let val_rev = map_rev.entry(words[i].clone()).or_insert(chars[i]);
            if *val != words[i] || *val_rev != chars[i] {
                return false
            }
        }
        true
    }
}