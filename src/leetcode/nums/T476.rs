pub struct Solution {}

impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        let mut hh: i64 = 1;
        while hh <= num as i64 {
            hh = hh << 1;
        }
        (hh - num as i64) as i32 - 1
    }
}