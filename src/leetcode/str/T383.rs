use std::collections::{HashMap};

pub struct Solution {

}

impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        let mut map = HashMap::new();
        magazine.as_bytes().into_iter().for_each(|x| {
            let val = map.entry(x).or_insert(0);
            *val += 1;
        });
        let mut count = true;
        ransom_note.as_bytes().into_iter().for_each(|x| {
            if !map.contains_key(x) {
                count = false;
            }
            let val = map.entry(x).or_insert(0);
            if *val == 0 {
                count = false;
            } else {
                *val -= 1;
            }
        });
        count
    }
}