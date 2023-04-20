pub struct Solution {

}

impl Solution {
    pub fn reconstruct_queue(mut people: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        people.sort_by(|a, b| {
           if a[0] == b[0] {
               a[1].cmp(&b[1])
           } else {
               b[0].cmp(&a[0])
           }
        });
        let mut res = vec![];
        for person in people {
            if (person[1] as usize) < res.len() {
                res.insert(person[1] as usize, person.clone());
            } else {
                res.push(person.clone());
            }
        }
        res
    }
}