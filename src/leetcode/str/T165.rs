use std::cmp::{max, min};

pub struct Solution {

}

impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        let vec1 = version1.split(".").map(|x| x.to_string()).collect::<Vec<String>>();
        let vec2 = version2.split(".").map(|x| x.to_string()).collect::<Vec<String>>();
        let mut i: usize = 0;
        while i < vec1.len() || i < vec2.len() {
            let mut val1 = 0;
            let mut val2 = 0;
            if i < vec1.len() {
                val1 = vec1[i].clone().trim_start_matches('0').parse::<i32>().unwrap_or(0);
            }
            if i < vec2.len() {
                val2 = vec2[i].clone().trim_start_matches('0').parse::<i32>().unwrap_or(0);
            }
            if val1 > val2 {
                return 1
            } else if val1 < val2 {
                return -1
            }
            i += 1;
        }
        0
    }
}
