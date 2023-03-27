use std::collections::{BTreeMap, HashMap};

pub struct Solution {

}
impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        let mut map = HashMap::new();
        strs.into_iter().for_each(|x| {
            let key = Solution::get_key(x.as_str());
            let vec = map.entry(key).or_insert(vec![]);
            (*vec).push(x);
        });
        map.into_iter().map(|(k,v)| v).collect::<Vec<Vec<String>>>()
    }

    pub fn get_key(s: &str) -> String {
        let mut map = BTreeMap::new();
        s.chars().for_each(|x| {
            let val = map.entry(x).or_insert(0);
            *val += 1;
        });
        map.into_iter().map(|(k, v)| format!("{}{}", k,v)).collect::<Vec<String>>().join("")
    }
    pub fn get_key1(s: &str) -> String {
        let mut chars = s.chars().collect::<Vec<char>>();
        chars.sort();
        chars.into_iter().collect::<String>()
    }
}