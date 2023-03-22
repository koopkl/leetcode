pub struct Solution {

}
impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        if num_rows == 1 {
            return vec![vec![1]]
        }
        if num_rows == 2 {
            return  vec![vec![1], vec![1,1]];
        }
        let mut res: Vec<Vec<i32>> = vec![vec![1], vec![1,1]];
        let mut count: usize = 2;
        while count < num_rows as usize {
            let mut i = 0;
            let mut j: usize = 1;
            let mut new_vec = vec![1];
            while j < count {
                let k: usize = (count - 1) as usize;
                new_vec.push(res[k][i] + res[k][j]);
                i += 1;
                j += 1;
            }
            new_vec.push(1);
            res.push(new_vec);
            count += 1;
        }
        res
    }
}