pub struct Solution {

}
impl Solution {
    pub fn range_bitwise_and(mut left: i32, mut right: i32) -> i32 {
        let mut count = 0;
        while right > left {
            count += 1;
            right >>= 1;
            left >>= 1;
        }
        return left << count;
    }
}