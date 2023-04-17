use std::collections::{HashMap, HashSet};

pub struct Solution {}

impl Solution {
    pub fn remove_duplicate_letters(s: String) -> String {
        let mut times = HashMap::new();
        s.as_bytes().iter().for_each(|x| {
            let val = times.entry(x).or_insert(0);
            *val += 1;
        });
        // println!("{:?}", times);
        let mut res = vec![];
        let mut set = HashSet::new();
        s.as_bytes().iter().for_each(|x| {
            let val = times.get_mut(x).unwrap();
            *val -= 1;
            // println!("{:?}", set);
            // println!("{:?}", res);
            // println!("{x}");
            if !set.contains(x) {
                while res.len() > 0 && res.last().unwrap() > x {
                    if *times.get(res.last().unwrap()).unwrap() == 0 {
                        break;
                    }
                    set.remove(res.last().unwrap());
                    res.pop();
                }
                res.push(x.clone());
                set.insert(x.clone());
            }
        });
        res.into_iter().map(|x|x as char).collect::<String>()
        // "".to_string()
    }
}