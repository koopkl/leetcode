pub struct Solution {}

impl Solution {
    pub fn is_power_of_two(x: i32) -> bool {
        if x < 0 {
            return false;
        }
        if x == 0 {
            return false
        }
        if x == 1 {
            return true
        }
        if x % 2 == 0 {
            Self::is_power_of_two(x / 2)
        } else {
            false
        }
    }
}