pub struct Solution {
    
}

impl Solution {
    pub fn can_complete_circuit(gas: Vec<i32>, cost: Vec<i32>) -> i32 {
        let len = gas.len();
        let mut i = 0;
        while i < len {
            let mut sum_gas = 0;
            let mut sum_cost = 0;
            let mut count = 0;
            while count < len {
                let j = (i + count) % len;
                sum_cost += cost[j];
                sum_gas += gas[j];
                if sum_cost > sum_gas {
                    break
                }
                count += 1;
            }
            if count == len {
                return i as i32;
            } else {
                i += count + 1;
            }
        }
        -1
    }
}