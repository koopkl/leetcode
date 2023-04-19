pub struct Solution {

}
impl Solution {
    pub fn array_pair_sum(mut nums: Vec<i32>) -> i32 {
        nums.sort();
        let mut count = 0;
        let mut sum = 0;
        nums.into_iter().for_each(|x| {
            if count % 2 == 0 {
                sum += x;
            }
            count += 1;
        });
        sum
    }
}